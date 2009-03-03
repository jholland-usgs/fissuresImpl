// **********************************************************************
//
// Generated by the ORBacus IDL to Java Translator
//
// Copyright (c) 2000
// Object Oriented Concepts, Inc.
// Billerica, MA, USA
//
// All Rights Reserved
//
// **********************************************************************
// Version: 4.0.3
package edu.iris.Fissures.event;

//
// IDL:iris.edu/Fissures/IfEvent/Origin:1.0
//
/***/
import java.util.ArrayList;
import java.util.List;

import edu.iris.Fissures.Location;
import edu.iris.Fissures.Time;
import edu.iris.Fissures.IfEvent.Magnitude;
import edu.iris.Fissures.IfEvent.Origin;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.model.LocationUtil;
import edu.iris.Fissures.model.MicroSecondDate;
import edu.iris.Fissures.model.ParameterRefUtil;
import edu.iris.Fissures.model.UnitImpl;

public class OriginImpl extends Origin {

    protected OriginImpl() {setParmIds(new ParameterRef[0]);}

    /** Only for use for CORBA object serialization. */
    public static OriginImpl createEmpty() {
        return new OriginImpl();
    }

    public OriginImpl(String id, String catalog, String contributor,
            Time origin_time, Location my_location, Magnitude[] magnitudes,
            ParameterRef[] parm_ids) {
        this.id = id;
        this.setCatalog(catalog);
        this.setContributor(contributor);
        this.setOriginTime(origin_time);
        this.setLocation(my_location);
        this.setMagnitudes(magnitudes);
        this.setParmIds(parm_ids);
    }

    //
    // IDL:iris.edu/Fissures/IfEvent/Origin/get_id:1.0
    //
    public String get_id() {
        return id;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(o instanceof OriginImpl) {
            OriginImpl oOrigin = (OriginImpl)o;
            if(equalsExceptTime(oOrigin) && oOrigin.getTime().equals(getTime())) { return true; }
        }
        return false;
    }

    public boolean equalsExceptTime(OriginImpl oOrigin) {
        if(oOrigin == this) {
            return true;
        } else if(LocationUtil.areEqual(oOrigin.getLocation(), getLocation())
                && oOrigin.getCatalog().equals(getCatalog())
                && oOrigin.getContributor().equals(getContributor())
                && MagnitudeUtil.areEqual(getMagnitudes(), oOrigin.getMagnitudes())
                && ParameterRefUtil.areEqual(getParmIds(), oOrigin.getParmIds())) { return true; }
        return false;
    }

    /**
     * does an equals, except origin times within 1 millisecond are judged to be
     * the same.
     */
    public boolean close(OriginImpl oOrigin) {
        if(oOrigin == this) {
            return true;
        } else if(equalsExceptTime(oOrigin)) {
            MicroSecondDate myOTime = new MicroSecondDate(getOriginTime());
            MicroSecondDate eventOTime = new MicroSecondDate(oOrigin.getOriginTime());
            if(myOTime.subtract(eventOTime).convertTo(UnitImpl.MICROSECOND).value < 1000) { return true; }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = 29;
        result += 89 * result + LocationUtil.hash(getLocation());
        result += 89 * result + getTime().hashCode();
        result += 89 * result + getContributor().hashCode();
        result += 89 * result + getCatalog().hashCode();
        result += 89 * result + ParameterRefUtil.hash(getParmIds());
        result += 89 * result + MagnitudeUtil.hash(getMagnitudes());
        return result;
    }

    public Time getFissuresTime() {
        return getOriginTime();
    }

    public MicroSecondDate getTime() {
        if(time == null) {
            time = new MicroSecondDate(getOriginTime());
        }
        return time;
    }

    private MicroSecondDate time;
    
    // for hibernate
    private int dbid;
    protected void setDbid(int dbid) {
        this.dbid = dbid;
    }
    public int getDbid() { return dbid;}
    
    protected void set_id(String id) {
        this.id = id;
    }
    
    public List getMagnitudeList() {
        // hibernate needs same collection returned from get as it put in via set for dirty checking
        if(hibernateMagList != null) {return hibernateMagList;}
        ArrayList out = new ArrayList();
        for(int i = 0; i < getMagnitudes().length; i++) {
            out.add(getMagnitudes()[i]);
        }
        return out;
    }
    
    protected void setMagnitudeList(List list) {
        hibernateMagList = list;
        setMagnitudes(new Magnitude[list.size()]);
        setMagnitudes((Magnitude[])list.toArray(getMagnitudes()));
    }
    
    protected List hibernateMagList = null;
}