package demo.repository;

import demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.product_id = ?1")
    List findByProduct_id(long id);
    @Query("select c from Comment c where c.employee_id = ?1")
    List findByEmployee_id(long id);
    @Query("select c from Comment c where c.employee_id = ?1 and c.created_at between ?2 and ?3 order by c.created_at")
    List findByEmployee_idAndCreated_atBetweenOrderByCreated_atAsc(long employeeId, Date start_created_at, Date end_created_at );

    @Query("select c from Comment c where c.product_id = ?1 and c.created_at between ?2 and ?3 order by c.created_at")
    List findByProduct_idAndCreated_atBetweenOrderByCreated_atAsc(long productId, Date start_created_at, Date end_created_at );
}