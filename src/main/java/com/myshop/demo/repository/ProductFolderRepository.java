package com.myshop.demo.repository;

import com.myshop.demo.entity.Folder;
import com.myshop.demo.entity.Product;
import com.myshop.demo.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long>{

    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}
