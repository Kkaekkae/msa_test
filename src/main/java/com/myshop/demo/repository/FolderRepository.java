package com.myshop.demo.repository;

import com.myshop.demo.entity.Folder;
import com.myshop.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder , Long> {
    List<Folder> findAllByUserAndNameIn(User user, List<String> foldersNames);

    List<Folder> findAllByUser(User user);
}
