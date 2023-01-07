package org.Jhon.learning.Models.Structure;

import org.Jhon.learning.ApiTesting.URLTypes;

public interface IModel {
  default URLTypes getURLStructure(){return null;}
}
