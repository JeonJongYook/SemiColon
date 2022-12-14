package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.Authority;
import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.enumclass.UserStatus;
import com.webmister.semicolon.repository.AuthorityRepository;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.Login;
import com.webmister.semicolon.request.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfoService
            (
                    UserInfoRepository userInfoRepository,
                    AuthorityRepository authorityRepository,
                    PasswordEncoder passwordEncoder)
    {
        this.userInfoRepository = userInfoRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserInfo findUserInfoById(Long id){
        return userInfoRepository.findById(id).orElse(new UserInfo());
    }

    public UserInfo findUserInfoByUserNickname(String userNickname){
        return userInfoRepository.findUserInfoByUserNickName(userNickname);
    }

    public List<UserInfo> findAll(){
        List<UserInfo> AllUser = userInfoRepository.findAll();
        System.out.println(AllUser);
        return AllUser;
    }

    public boolean checkDuplicateEmail(String userEmail) {
        return userInfoRepository.existsByUserEmail(userEmail);
    }

    public boolean checkDuplicateUserNickname(String userNickname) {
        return userInfoRepository.existsByUserNickName(userNickname);
    }

    public UserInfo login(Login login) {
        log.info("서비스 로그인");

        return userInfoRepository.findByUserEmailAndPassword(login.getUserEmail(), login.getPassword())
                .orElse(new UserInfo());
    }

    public Boolean saveRefreshToken(String email, String refreshToken){

        UserInfo userInfo = userInfoRepository.findByUserEmail(email)
                .orElse(new UserInfo()); // 수정 필요한지 검토

        try {
            userInfoRepository.save(userInfo.setRefreshToken(refreshToken));

            log.info("리프레시 저장");
            log.info(userInfo.getRefreshToken());
            return Boolean.TRUE;

        }catch (Exception e){

            log.info("리프레시 실패");
            return Boolean.FALSE;
        }
    }

    public UserInfo updatePasswordService(String email, String password) {
        UserInfo userInfo = userInfoRepository.findByUserEmail(email)
                .orElse(new UserInfo());
        userInfoRepository.save(userInfo.setPassword(password));
        return userInfo;
    }

    public Boolean signUp(UserInfoRequest userInfoRequest) {

        try {

            userInfoRepository.save(UserInfo.builder()
                    .password(passwordEncoder.encode(userInfoRequest.getPassword()))
                    .decodedPassword(userInfoRequest.getPassword())
                    .userEmail(userInfoRequest.getUserEmail())
                    .userNickName(userInfoRequest.getUserNickname())
                    .userUniqueID(UserStatus.USER)
                    .userProfileImageUrl(userInfoRequest.getUserProfileImageUrl())
                    .userDescription(userInfoRequest.getUserDescription())
                    .refreshToken(userInfoRequest.getRefreshToken())
                    .userEmailAuthKey(createRandomKey())
                    .authorities(Collections.singleton(authorityRepository.save(Authority.builder().authorityName("ROLE_USER").build())))
                    .activated(true)
                    .build());

            log.info("서비스 회갑");
            return Boolean.TRUE;
        } catch (Exception e) {
            log.info("서비스 회갑 실패");
            return Boolean.FALSE;
        }
    }

    public Boolean deleteUser(String userNickname){
        try{
            userInfoRepository.deleteById(userInfoRepository.findByUserNickName(userNickname).getUserInfoId());
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public UserInfo findByUserEmail(String userEmail) {
        return userInfoRepository.findByUserEmail(userEmail).orElse(new UserInfo());
    }

    public void mailAuthSuccess(String userNickname) {
        UserInfo userInfo = findUserInfoByUserNickname(userNickname);
        userInfo.setUserEmailAuthState(true);
        userInfoRepository.save(userInfo);
    }

    public String createRandomKey() {
        Random random = new Random();
        int creatNumber = 0;
        String numberToString = "";
        String resultKey = "";

        for(int i = 0; i < 10; i++) {
            creatNumber = random.nextInt(9);
            numberToString = Integer.toString(creatNumber);
            resultKey += numberToString;
        }
        return resultKey;
    }
}

