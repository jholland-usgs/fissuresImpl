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

package edu.iris.Fissures.network;

import edu.iris.Fissures.IfNetwork.Sensor;

//
// IDL:iris.edu/Fissures/IfNetwork/Sensor:1.0
//
/***/

public class SensorValueFactory implements org.omg.CORBA.portable.ValueFactory
{
    public java.io.Serializable
    read_value(org.omg.CORBA_2_3.portable.InputStream in)
    {
        // TODO: implement
        Sensor result = SensorImpl.createEmpty();
        return in.read_value(result);
    }
}
