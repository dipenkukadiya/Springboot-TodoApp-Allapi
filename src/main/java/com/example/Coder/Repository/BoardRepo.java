package com.example.Coder.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;

public interface BoardRepo extends JpaRepository<Board,Long>{

    Board findByIdAndWorkspace(Long board_id, Workspace workspace);

    void deleteByIdAndWorkspace(Long boardId, Workspace workspace);

 
    
}
