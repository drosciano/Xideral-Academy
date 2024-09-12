package com.example.FinalProject.Config;

import com.example.FinalProject.Entity.Belt;
import com.example.FinalProject.Entity.Student;
import org.springframework.batch.item.ItemProcessor;

public class BeltProcessor implements ItemProcessor<Belt, Belt> {
    @Override
    public Belt process(Belt item) throws Exception {
        return item;
    }
}
