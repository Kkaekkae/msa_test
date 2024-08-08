package com.myshop.demo.repository;

import com.myshop.demo.dto.ProductResponseDto;
import com.myshop.demo.entity.Folder;
import com.myshop.demo.entity.Product;
import com.myshop.demo.entity.ProductFolder;
import com.myshop.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);
    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pageable);

}
