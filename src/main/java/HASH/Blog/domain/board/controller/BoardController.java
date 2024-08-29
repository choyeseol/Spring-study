package HASH.Blog.domain.board.controller;

import HASH.Blog.domain.board.controller.dto.BoardRequestDto;
import HASH.Blog.domain.board.controller.dto.BoardResponseDto;
import HASH.Blog.domain.board.service.CommandBoardService;
import HASH.Blog.domain.board.service.QueryBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final CommandBoardService commandBoardService;
    private final QueryBoardService queryBoardService;

    @PostMapping
    public void create(@RequestBody BoardRequestDto boardRequestDto) {
        commandBoardService.create(boardRequestDto);
    }

    @GetMapping
    public List<BoardResponseDto> readAll(){
        return queryBoardService.readAll();
    }

    @GetMapping("/{id}")
    public BoardResponseDto findOne(@PathVariable Long id) {
        return queryBoardService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id) {
        commandBoardService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        commandBoardService.update(boardRequestDto, id);
    }

}