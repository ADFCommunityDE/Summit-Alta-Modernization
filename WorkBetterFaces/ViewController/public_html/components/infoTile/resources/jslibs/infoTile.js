/*Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.*/
InfoTileComp = {}

InfoTileComp.raiseSelectionEvent = function(evt)
{
  var source = evt.getSource();
  var index = source.getProperty("index");
  var selected = false;
  
  while(index == null)
  {
    source = source.getParent();
    index = source.getProperty("index");
    selected = source.getProperty("selected");
  }

  // If the tile is already selected there is no need to raise selection event
  if(!selected)
  {
    // Go past the Declarative component definition and into its parent  
    source = source.getParent();
    
    // Go past the conveyor belt if any
    if (source.getComponentType().indexOf("RichConveyorBelt") != -1)
    {
      source = source.getParent();
    }
    
    (new AdfCustomEvent(source, "tileSelected", {"index": index}, false)).queue();
    evt.cancel();
  }
}
