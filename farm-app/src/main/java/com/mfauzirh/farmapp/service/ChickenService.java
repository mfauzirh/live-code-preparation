package com.mfauzirh.farmapp.service;

import com.mfauzirh.farmapp.dto.ChickenDTO;
import com.mfauzirh.farmapp.entity.Chicken;
import com.mfauzirh.farmapp.entity.Income;
import com.mfauzirh.farmapp.repository.ChickenRepository;
import com.mfauzirh.farmapp.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChickenService {

    private final ChickenRepository chickenRepository;
    private final IncomeRepository incomeRepository;

    public Chicken createChicken(ChickenDTO chickenDTO) {
        Chicken chicken = new Chicken();
        chicken.setName(chickenDTO.getName());
        chicken.setEggCount(chickenDTO.getEggCount());
        chicken.setPricePerEgg(chickenDTO.getPricePerEgg());

        Chicken savedChicken = chickenRepository.save(chicken);
        updateIncome();
        return savedChicken;
    }

    public List<ChickenDTO> findAllChickens() {
        return chickenRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ChickenDTO convertToDTO(Chicken chicken) {
        ChickenDTO dto = new ChickenDTO();
        dto.setName(chicken.getName());
        dto.setEggCount(chicken.getEggCount());
        dto.setPricePerEgg(chicken.getPricePerEgg());
        return dto;
    }

    private void updateIncome() {
        List<Chicken> chickens = chickenRepository.findAll();
        int totalEggs = chickens.stream().mapToInt(Chicken::getEggCount).sum();
        double totalIncome = chickens.stream().mapToDouble(chicken -> chicken.getEggCount() * chicken.getPricePerEgg()).sum();

        Income income = incomeRepository.findById(1L).orElse(new Income());
        income.setTotalEggs(totalEggs);
        income.setTotalIncome(totalIncome);
        incomeRepository.save(income);
    }
}
