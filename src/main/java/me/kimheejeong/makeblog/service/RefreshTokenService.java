package me.kimheejeong.makeblog.service;

import lombok.RequiredArgsConstructor;
import me.kimheejeong.makeblog.domain.RefreshToken;
import me.kimheejeong.makeblog.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new IllegalArgumentException("Unexpected token"));
    }
}
