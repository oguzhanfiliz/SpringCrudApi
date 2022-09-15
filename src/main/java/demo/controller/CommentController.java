package demo.controller;

import demo.entity.Comment;
import demo.entity.DateRequest;
import demo.service.CommentService;
import org.hibernate.annotations.CreationTimestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/save")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){

        Date dtf = new Date();
        comment.setCreated_at(dtf);
        Comment savedComment = commentService.saveComment(comment);
        return new ResponseEntity<Comment>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComment(){
        List<Comment> allComment = commentService.getAllComment();
        return new ResponseEntity<List<Comment>>(allComment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(name = "id") Long commentId){
        Comment comment = commentService.getCommentById(commentId);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateCommentById(@RequestBody Comment comment){
        Comment updatedComment = commentService.updateComment(comment);
        return new ResponseEntity<Comment>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable(name = "id") Long commentId){
        commentService.deleteCommentById(commentId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<List> getCommentByProductId(@PathVariable(name = "id") Long productId) {
        List comments = commentService.findByProduct_id(productId);
        return new ResponseEntity(comments, HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<List> getCommentByEmployeeId(@PathVariable(name = "id") Long employeeId) {
        List comments = commentService.findByEmployee_id(employeeId);
        return new ResponseEntity(comments, HttpStatus.OK);
    }
    @RequestMapping(value="/employee/search/{id}",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<List> getEmployeeCommentTwoDateBetween(@PathVariable(name = "id") Long employeeId, @RequestBody DateRequest data) {
        List comments = commentService.getEmployeeCommentTwoDateBetween(employeeId,data.getStart_date(),data.getEnd_date());
        return new ResponseEntity(comments, HttpStatus.OK);
    }
    @RequestMapping(value="/product/search/{id}",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<List> getProductCommentTwoDateBetween(@PathVariable(name = "id") Long productId, @RequestBody DateRequest data) {
        List comments = commentService.getProductCommentTwoDateBetween(productId,data.getStart_date(),data.getEnd_date());
        return new ResponseEntity(comments, HttpStatus.OK);
    }



}
