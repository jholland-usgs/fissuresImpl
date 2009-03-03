
package edu.iris.Fissures.seismogramDC;


/**
 * <ul>
 * <li> <b>IDL Source</b>    "IfDataCenter.idl"
 * <li> <b>IDL Name</b>      ::Fissures::IfDataCenter::SeismogramAttr
 * <li> <b>Repository Id</b> IDL:edu.iris/Fissures/IfDataCenter/SeismogramAttr:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * valuetype SeismogramAttr : edu.iris.Fissures.IfDataCenter.SeismogramAttr {
  ...
};
 * </pre>
 */
public class SeismogramAttrValueFactory implements org.omg.CORBA.portable.ValueFactory {
  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
    java.io.Serializable val = edu.iris.Fissures.seismogramDC.SeismogramAttrImpl.createEmpty();
    // create and initialize value
    return is.read_value(val);
  }
}
