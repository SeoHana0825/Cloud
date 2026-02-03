package com.taskcloud.controller;

import com.taskcloud.dto.MemberCreateRequest;
import com.taskcloud.dto.MemberCreateResponse;
import com.taskcloud.dto.MemberGetResponse;
import com.taskcloud.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    // POST
    @PostMapping
    public ResponseEntity<MemberCreateResponse> create(
            @RequestBody MemberCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }

    // GET 전체 조회
    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());
    }

    // GET 단건 조회
    @GetMapping("{id}")
    public ResponseEntity<MemberGetResponse> getOne(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findOne(id));
    }
}
