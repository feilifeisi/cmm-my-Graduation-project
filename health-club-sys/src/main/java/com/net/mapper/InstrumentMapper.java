package com.net.mapper;

import com.net.entity.InstruUsers;
import com.net.entity.Instrument;
import com.net.entity.Transfer;

import java.util.List;
import java.util.Map;

public interface InstrumentMapper {

    List<Instrument> selInstrumentList(Map<String,Object> map);

    int updInstrumentList(Instrument instrument);

    int inserttransfer(Transfer transfer);

    Instrument selInstrumentListById(int id);

    List<InstruUsers> selInstrumentUsers(Map<String,Object> map);

    int deletetransfer(int id);

    int addInstrument(Instrument instrument);

    Instrument addInstrumentByName(String name);

    List<Instrument> selInstrumentBaoJin();

    int delet(int id);

}
