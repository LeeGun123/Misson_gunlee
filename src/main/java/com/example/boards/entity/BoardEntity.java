package com.example.boards.entity;

import com.example.boards.dto.BoardDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name = "board_Table")
public class BoardEntity {
    @Id // pk 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column // 크기 255, null 가능
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDto boardDto) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardPass(boardDto.getBoardPass());
        boardEntity.setBoardTitle(boardDto.getBoardTitle());
        boardEntity.setBoardContents(boardDto.getBoardContents());
        return boardEntity;
    }

    public static BoardEntity toUpdateEntity(BoardDto boardDto) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDto.getId());
        boardEntity.setBoardPass(boardDto.getBoardPass());
        boardEntity.setBoardTitle(boardDto.getBoardTitle());
        boardEntity.setBoardContents(boardDto.getBoardContents());
        return boardEntity;
    }
}
