package com.example.herokuapp.service.impls;

import com.example.herokuapp.entity.Guy;
import com.example.herokuapp.repository.GuyRepository;
import com.example.herokuapp.service.GuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GuyServiceImpl implements GuyService {
    @Autowired
    private GuyRepository guyRepository;

    private static final Random random = new Random();

    @Override
    public void save(Guy guy) {
        guyRepository.save(guy);
    }

    @Override
    public Guy getGayGuy() {
        List<Guy> all = guyRepository.findAll();
        Double randomMax = all.stream()
                              .map(g -> g.getPercentage() * 10)
                              .reduce((a, b) -> a + b)
                              .orElse(0d);
        int rand = random.nextInt(randomMax.intValue() + 1);
        Guy gay = getGay(all, rand);
        gay.setPercentage(0d);
        all.stream()
           .filter(x -> !x.getId()
                          .equals(gay.getId()))
           .forEach(x -> x.setPercentage(x.getPercentage() + 10));
        guyRepository.saveAll(all);
        return gay;
    }

    private Guy getGay(List<Guy> all, int rand) {
        int acc = 0;
        for (Guy guy : all) {
            Double v = guy.getPercentage() * 10;
            int sizeOfRange = v.intValue();
            if (rand >= acc && rand <= acc + sizeOfRange) {
                return guy;
            } else {
                acc += sizeOfRange;
            }
        }
        throw new RuntimeException("You need to rerun");
    }


}
