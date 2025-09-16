package com.spring.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.application.command.PageMaker;
import com.spring.application.dto.BoardVO;

public interface BoardDAO {
    List<BoardVO> selectSearchBoardList(PageMaker pageMaker) throws SQLException;

    int selectSearchBoardListCount(PageMaker pageMaker) throws SQLException;

    BoardVO selectBoardByBno(int bno) throws SQLException;

    void insertBoard (BoardVO board) throws SQLException;

    void updateBoard (BoardVO board) throws SQLException;

    void deleteBoard (int bno) throws SQLException;

    void increaseViewCount (int bno) throws SQLException;

    int selectBoardSeqNext () throws SQLException;


}
