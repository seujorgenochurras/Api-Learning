package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.Structures.URLTypes;
import org.Jhon.learning.Models.Structure.IModel;

public interface Request extends IModel {
 StringBuilder getURL();
 URLTypes getURLStructure();

 default Class<? extends IModel> getCorrespondentModel(){
  return null;
 }
}


