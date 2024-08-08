package com.myshop.demo.controller;

import com.myshop.demo.dto.FolderRequestDto;
import com.myshop.demo.dto.FolderResponseDto;
import com.myshop.demo.security.UserDetailsImpl;
import com.myshop.demo.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FolderController {


    private final FolderService folderService;
    @PostMapping("/folders")
    public void addFolders(@RequestBody FolderRequestDto folderRequestDto , @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<String> foldersNames = folderRequestDto.getFolderNames();
        folderService.addFolders(foldersNames , userDetails.getUser());


    }

    @GetMapping("/folders")
    public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return folderService.getFolders(userDetails.getUser());
    }

}
