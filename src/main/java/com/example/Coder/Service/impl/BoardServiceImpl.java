package com.example.Coder.Service.impl;

import com.example.Coder.DTO.BoardDTO;
import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
import com.example.Coder.Repository.BoardRepo;
import com.example.Coder.Repository.WorkspaceRepo;
import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepo boardRepo;

    @Autowired
    private WorkspaceRepo workspaceRepo;

    @Override
    public List<BoardDTO> getAllBoards() {
        List<Board> boards = boardRepo.findAll();

        return boards.stream()
                .map(this::convertBoardToDTO).collect(Collectors.toList());
    }

    @Override
    public List<BoardDTO> getAllBoardByWorkspaceId(Long workspaceId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            return convertBoardsToDTOs(workspace.getBoards());
        }
        return null;
    }

    @Override
    public BoardDTO getBoardByWorkspaceid(Long workspaceId, Long boardId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            return convertBoardToDTO(boardRepo.findByIdAndWorkspace(boardId, workspace));
        }
        return null;
    }

    @Override
    public void addBoard(Long workspaceId, BoardRequest boardRequest) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = new Board();
            board.setTitle(boardRequest.getTitle());
            board.setDescription(boardRequest.getDescription());
            board.setIsFavorite(boardRequest.getIsFavorite());
            board.setWorkspace(workspace);
            boardRepo.save(board);
        }
    }

    @Override
    public void updateBoard(Long workspaceId, Long boardId, BoardRequest boardRequest) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = boardRepo.findByIdAndWorkspace(boardId, workspace);
            if (board != null) {
                board.setTitle(boardRequest.getTitle());
                board.setDescription(boardRequest.getDescription());
                board.setIsFavorite(boardRequest.getIsFavorite());
                board.setWorkspace(workspace);
                boardRepo.save(board);
            }
        }
    }

    @Override
    public void removeBoard(Long workspaceId, Long boardId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            boardRepo.deleteById(boardId);
        }
    }

    @Override
    public void toggleBoardIsFavorite(Long workspaceId, Long boardId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).orElse(null);
        if (workspace != null) {
            Board board = boardRepo.findByIdAndWorkspace(boardId, workspace);
            if (board != null) {
                board.setIsFavorite(!board.getIsFavorite());
                boardRepo.save(board);
            }
        }
    }

    private List<BoardDTO> convertBoardsToDTOs(List<Board> boards) {
        return boards.stream()
                .map(this::convertBoardToDTO)
                .collect(Collectors.toList());
    }

    private BoardDTO convertBoardToDTO(Board board) {
        BoardDTO boardDTO = new BoardDTO();
        // Board board = boardRepo.find

        boardDTO.setId(board.getId());
        boardDTO.setTitle(board.getTitle());
        boardDTO.setDescription(board.getDescription());
        boardDTO.setIsFavorite(board.getIsFavorite());
        boardDTO.setWorkspaceId(board.getWorkspace().getId());

        return boardDTO;
    }

}
