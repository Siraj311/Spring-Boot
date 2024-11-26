package com.learnwithiftikar.native_query;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select * from books b where lower(b.title) like %:title%", nativeQuery = true)
    List<Book> findBooksByTitleThatContainsWord(@Param("title") String title);

    @Query(
            value = "update books set price = :price where id = :id",
            nativeQuery = true
    )
    @Modifying
    @Transactional
    void updateBookPrice(@Param("price") double price, @Param("id") long id);
}
