package guru.springframework.services;

import org.springframework.stereotype.Service;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.repositories.reactive.UnitOfMeasureReactiveRepository;
import reactor.core.publisher.Flux;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

  private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
  private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

  public UnitOfMeasureServiceImpl(
      UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository,
      UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
    this.unitOfMeasureReactiveRepository = unitOfMeasureReactiveRepository;
    this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
  }

  @Override
  public Flux<UnitOfMeasureCommand> listAllUoms() {

    return unitOfMeasureReactiveRepository.findAll().map(unitOfMeasureToUnitOfMeasureCommand::convert);
    //        return StreamSupport.stream(unitOfMeasureRepository.findAll()
    //                .spliterator(), false)
    //                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
    //                .collect(Collectors.toSet());
  }
}