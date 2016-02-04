package com.build.devtest;

import java.util.ArrayList;
import java.util.List;

public class ParentViewMapperImpl implements ParentViewMapper{ 
   
  /**
   * ParentViewMapperImpl constructor.
   **/
  public ParentViewMapperImpl(){}

  /**
   * Return a List of ParentView objects with childRows mapped to parentRows
   * using childRows foreign key (parentId).
   * @param parentRows  a List of parentRow objects
   * @param childRows   a List of childRow objects
   * @return            the List of parentView objects with mapped childViews
   */
  public List<ParentView> mapRowsToViews(List<ParentRow> parentRows, List<ChildRow> childRows){
    List<ParentView> parentViews = new ArrayList<ParentView>();
    for(ParentRow parentRow : parentRows){
      ParentView parentView = new ParentView(parentRow.getFirstName(), 
                                             parentRow.getLastName(),
                                             parentRow.getAge(), 
                                             parentRow.getParentId(),
                                             null);
      List<ChildView> childViews = new ArrayList<ChildView>();
      for(ChildRow childRow : childRows){
        if(childRow.getParentId().toLowerCase().equals(parentRow.getParentId().toLowerCase())){
          ChildView childView = new ChildView(childRow.getFirstName(),
                                              childRow.getLastName(),
                                              childRow.getAge(),   
                                              childRow.getChildId(),
                                              parentView);
          childViews.add(childView);
        }
      }
      parentView.setChildViews(childViews);
      parentViews.add(parentView);
    }
    return parentViews;
  }

}

