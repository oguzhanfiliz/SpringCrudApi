package demo.repository;

import demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.last_use_date < ?1 order by p.id")
    List findByLast_use_dateBeforeOrderById(Date lastUseDate);
    @Query("select p from Product p where p.last_use_date > ?1 or p.last_use_date is null order by p.id")
    List findByLast_use_dateAfterOrLast_use_dateNullOrderById(Date lastUseDate);

}