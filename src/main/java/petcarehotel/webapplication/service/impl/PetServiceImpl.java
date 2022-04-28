package petcarehotel.webapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.repository.PetRepository;
import petcarehotel.webapplication.service.PetService;

import javax.transaction.Transactional;

/**
 * Service implementation for the Pet entity.
 */
@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
  private final PetRepository petRepository;

  @Transactional
  @Override
  public void addPet(Pet pet) {
    this.petRepository.save(pet);
  }
}
