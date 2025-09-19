package com.spring.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.application.dto.AttachVO;

public interface AttachDAO {
    List<AttachVO> selectAttachByPno(int pno) throws SQLException;
    AttachVO selectAttachByAno(int ano) throws SQLException;

    void insertAttach(AttachVO attach) throws SQLException;
    void deleteAttach(int ano)throws SQLException;
    void deleteAttachAll(int pno)throws SQLException;

}
