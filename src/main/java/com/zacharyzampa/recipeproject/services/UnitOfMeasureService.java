package com.zacharyzampa.recipeproject.services;

import com.zacharyzampa.recipeproject.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUnitOfMeasures();
}
