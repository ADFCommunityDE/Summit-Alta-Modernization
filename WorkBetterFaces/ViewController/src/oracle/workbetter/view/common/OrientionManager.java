//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.common;

import java.io.Serializable;

/**
 * Session scope bean which remembers the current orientation on the device and provides
 * a bunch of convenience functions to help simplify the pages
 */
public class OrientionManager implements Serializable {
    @SuppressWarnings("compatibility:-9161622147801318700")
    private static final long serialVersionUID = -63859150684533036L;

    private enum Orientation {PORTRAIT, LANDSCAPE};
    private Orientation _orientation = Orientation.LANDSCAPE;
    
    public void setOrientation(String orientation){
        _orientation = Orientation.valueOf(orientation.toUpperCase());    
    }
    
    public String getOrientation(){
        return _orientation.toString().toLowerCase();    
    }

    
    public boolean isPortraitMode(){
        return (_orientation == Orientation.PORTRAIT);
    }
    
    public boolean isLandscapeMode(){
        return (_orientation == Orientation.LANDSCAPE);
    }
    
    public String getInfoTileGroupLayout(){
        return (!isPortraitMode())?"vertical":"horizontal";        
    }
    
    public String getInfoTileLayout(){
        return (isPortraitMode())?"vertical":"horizontal";        
    }
    
    public String getOrgInfoTileWidth(){
        return (isPortraitMode())?"160px":"320px";        
    }
    
    public String getPersonInfoTileWidth(){
        return (isPortraitMode())?"158px":"188px";        
    }
    
    public String getOrgInfoTileHeight(){
        return (isPortraitMode())?"193px":"140px";        
    }
    
    public String getPersonInfoTileHeight(){
        return (isPortraitMode())?"100px":"140px";        
    }


    public String getInfoTileDeckForwardTransition(){
        return (isPortraitMode())?"slideDown":"slideStart";        
    }

    public String getInfoTileDeckBackTransition(){
        return (isPortraitMode())?"slideUp":"slideEnd";        
    }


      
}
