package org.Jhon.learning.Models;

import org.Jhon.learning.ApiTesting.URLRequests;
import org.Jhon.learning.ApiTesting.URLTypes;
import org.Jhon.learning.Models.Structure.GenericCarStructure;
import org.Jhon.learning.Models.Structure.IModel;

import java.time.LocalDate;

public class Carro extends GenericCarStructure implements IModel {

  public static final LocalDate mesReferencia = LocalDate.of(2023,1,1);

}
