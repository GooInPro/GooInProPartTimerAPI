package org.gooinpro.gooinproparttimerapi.chatroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gooinpro.gooinproparttimerapi.chatroom.domain.ChatRoomEntity;
import org.gooinpro.gooinproparttimerapi.chatroom.dto.ChatRoomAddDTO;
import org.gooinpro.gooinproparttimerapi.chatroom.dto.ChatRoomFindDTO;
import org.gooinpro.gooinproparttimerapi.chatroom.dto.ChatRoomListDTO;
import org.gooinpro.gooinproparttimerapi.chatroom.service.ChatRoomService;
import org.gooinpro.gooinproparttimerapi.common.dto.PageRequestDTO;
import org.gooinpro.gooinproparttimerapi.common.dto.PageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chatroom")
@RequiredArgsConstructor
@Log4j2
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    //채팅방 만들기
    @PostMapping("create")
    public ResponseEntity<ChatRoomEntity> createChatRoom(@RequestBody ChatRoomAddDTO dto) {

        log.info("testestestestestesetestestestestest");
        log.info(dto.toString());

        return ResponseEntity.ok(chatRoomService.addChatRoomService(dto));
    }

    //채팅방 찾기(없으면 새로 만들어서 반환
    @PostMapping("find")
    public ResponseEntity<ChatRoomEntity> findChatRoom(@RequestBody ChatRoomFindDTO dto) {

        return ResponseEntity.ok(chatRoomService.findChatRoomService(dto));
    }

    //내 채팅방 리스트 get(paging 처리)
    @GetMapping("list/{email}")
    public ResponseEntity<PageResponseDTO<ChatRoomListDTO>> chatRoomList(
            @PathVariable String email, PageRequestDTO pageRequestDTO) {

        log.info(email);

        return ResponseEntity.ok(chatRoomService.chatRoomListService(email, pageRequestDTO));
    }
}
