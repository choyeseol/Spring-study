package HASH.Blog.domain.board.service;

import HASH.Blog.domain.board.controller.dto.BoardRequestDto;
import HASH.Blog.domain.board.domain.Board;
import HASH.Blog.domain.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandBoardService {


    private final BoardRepository boardRepository;

    public void create(BoardRequestDto boardRequestDto) {
        Board board = Board.builder()
                .title(boardRequestDto.title())
                .content(boardRequestDto.content())
                .build();


        boardRepository.save(board);
    }

    @Transactional
    public void update(BoardRequestDto boardRequestDto, Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        board.update(boardRequestDto);
    }

    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("삭제할 게시글이 없습니다."));

        boardRepository.delete(board);
    }

}
