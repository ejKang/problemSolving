package com.joo.book.springboot.springbootwebservice.service.posts;

import com.joo.book.springboot.springbootwebservice.domain.posts.Posts;
import com.joo.book.springboot.springbootwebservice.domain.posts.PostsRepository;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsResponseDto;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsUpdateRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

}