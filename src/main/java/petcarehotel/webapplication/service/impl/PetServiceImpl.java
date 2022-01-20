package petcarehotel.webapplication.service.impl;

import org.springframework.stereotype.Service;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.repository.PetRepository;
import petcarehotel.webapplication.service.PetService;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void addPet(Pet pet) {
        this.petRepository.save(pet);
    }
}
