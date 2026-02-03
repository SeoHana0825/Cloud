package com.taskcloud.service;

import com.taskcloud.dto.MemberCreateRequest;
import com.taskcloud.dto.MemberCreateResponse;
import com.taskcloud.dto.MemberGetResponse;
import com.taskcloud.entity.Member;
import com.taskcloud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // POST API
    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request) {

        // 로그 시작
        log.info("[API - LOG] 저장된 맴버 요청: {}, {}", request.getName(), request.getBirthday());
        Member member = new Member(
                request.getName(),
                request.getEmail(),
                request.getBirthday(),
                request.getMbti()
        );

        Member savedMember = memberRepository.save(member);

        // 로그 종료
        log.info("[API - LOG] 저장된 맴버 응답: ID: {}", savedMember.getId());
        return new MemberCreateResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getEmail(),
                savedMember.getBirthday(),
                savedMember.getMbti()
        );

    }

    // GET API - 전체 조회
    @Transactional(readOnly = true)
    public List<MemberGetResponse> findAll() {

        // 로그 시작
        log.info("[API - LOG] 맴버 전체 조회 요청");
        List<Member> members = memberRepository.findAll();
        List<MemberGetResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            MemberGetResponse dto = new MemberGetResponse(
                    member.getId(),
                    member.getName(),
                    member.getEmail(),
                    member.getBirthday(),
                    member.getMbti()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // GET API - 단건 조회
    @Transactional(readOnly = true)
    public MemberGetResponse findOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저입니다.")
        );

        // 로그 종료
        log.info("[API - LOG] 맴버 단건 조회 응답: id : {}", member.getId());
        return new MemberGetResponse(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getBirthday(),
                member.getMbti()
        );
    }
}