package com.exceldemodb.service;

import com.exceldemodb.helper.Helper;
import com.exceldemodb.model.Estore;
import com.exceldemodb.repo.EstoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class EstoreService {

    @Autowired
    private EstoreRepo estoreRepo;


    public ByteArrayInputStream getActualData() throws IOException {
         List<Estore> estoreList = estoreRepo.findAll();
         ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(estoreList);
         return byteArrayInputStream;

    }
}
