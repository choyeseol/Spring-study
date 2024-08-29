package HASH.Blog.domain.board.service;

import HASH.Blog.domain.board.controller.dto.BoardResponseDto;
import HASH.Blog.domain.board.domain.Board;
import HASH.Blog.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBoardService {
    private final BoardRepository boardRepository;

    public List<BoardResponseDto> readAll() {
        List<Board> boards = boardRepository.findAll();

        return boards.stream()
                .map(BoardResponseDto::from)
                .toList();
    }

    public BoardResponseDto findOne(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));

        return BoardResponseDto.from(board);
    }


}
