package com.authright.demo.service.implement;

import com.authright.demo.model.Contract;
import com.authright.demo.model.User;
import com.authright.demo.model.WeekTime;
import com.authright.demo.repository.ContractRepository;
import com.authright.demo.repository.WeekTimeRepository;
import com.authright.demo.service.WeekTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeekTimeServiceImp implements WeekTimeService {

    @Autowired
    private WeekTimeRepository weekTimeRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public WeekTime updateWeektime(WeekTime weekTime) {
//        weekTime.setWeekId(1L);
//        weekTime.setContract(contractRepository.getContractByCompanyName("Authright"));
//        Date mondayTime = weekTime.getMondayDate();
//        long time = mondayTime.getTime();
//        time -= time % (24*60*60*1000);
//        mondayTime.setTime(time);
//        System.out.println(mondayTime.toString());
//        weekTime.setMondayDate(mondayTime);
        weekTimeRepository.save(weekTime);
        return weekTime;
    }

    @Override
    public WeekTime submitWeektime(WeekTime weekTime) {
//        weekTime.setWeekId(1L);
        weekTime.setSubmitted(true);
        weekTimeRepository.save(weekTime);
        return weekTime;
    }

    @Override
    public List<WeekTime> getUnsubmittedWeekTimeListByUser(User user) {
        List<WeekTime> weekTimeList = getWeekTimeListByUser(user);
        return weekTimeList.stream().filter(weekTime -> !weekTime.isSubmitted()).collect(Collectors.toList());
    }

    @Override
    public List<WeekTime> getSubmittedWeekTimeListByUser(User user) {
        List<WeekTime> weekTimeList = getWeekTimeListByUser(user);
        return weekTimeList.stream().filter(weekTime -> weekTime.isSubmitted()).collect(Collectors.toList());
    }

    @Override
    public List<WeekTime> getWeekTimeListByUser(User user) {
        List<Contract> contractList = contractRepository.getContractsByUser(user);
        List<WeekTime> weekTimeList = new ArrayList<WeekTime>();
        Date now = new Date();
        for(Contract contract : contractList){
            weekTimeList.addAll(weekTimeRepository.getWeekTimesByContract(contract));
            Date startDate = contract.getStartDate();
            Date latestMondayDate = new Date(startDate.getTime());
            for(WeekTime weekTime : weekTimeList){
                if(latestMondayDate.before(weekTime.getMondayDate()))
                    latestMondayDate = weekTime.getMondayDate();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(latestMondayDate);
            calendar.add(7, Calendar.DATE);
            Date newMondayDate = calendar.getTime();
            while(newMondayDate.before(now)){
                WeekTime weekTime = new WeekTime();
                weekTime.setMondayDate(newMondayDate);
                weekTime.setContract(contract);
                weekTimeRepository.save(weekTime);
                weekTimeList.add(weekTime);
                calendar.add(7, Calendar.DATE);
                newMondayDate = calendar.getTime();
            }
        }
        return weekTimeList;
    }
}
