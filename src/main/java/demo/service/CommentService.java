package demo.service;

import demo.entity.Comment;
import demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId){
        return commentRepository.findById(commentId).get();
    }

    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Long commentId){
        commentRepository.deleteById(commentId);
    }
    public List findByProduct_id(Long commentId)
    {
        return commentRepository.findByProduct_id(commentId);
    }
    public List findByEmployee_id(Long employeeId)
    {
        return commentRepository.findByEmployee_id(employeeId);
    }

    public List getEmployeeCommentTwoDateBetween(Long employeeId, Date start_created_at, Date end_created_at)
    {

        return commentRepository.findByEmployee_idAndCreated_atBetweenOrderByCreated_atAsc(employeeId,start_created_at,end_created_at);
    }
    public List getProductCommentTwoDateBetween(Long productId, Date start_created_at, Date end_created_at)
    {

        return commentRepository.findByProduct_idAndCreated_atBetweenOrderByCreated_atAsc(productId,start_created_at,end_created_at);
    }

}
