package com.exceldemodb.repo;

import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EstoreRepoTest {

    @Autowired
    private EstoreRepo estoreRepo;

    @Test
    public void ERepo(){
        System.out.println("Test case passing");
    }

}