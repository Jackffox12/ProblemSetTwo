package com.example.pointlibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GridLogger {

    private LogWriter writer;
    private Clock clock;
    private ArrayList<String> arrayAdd = new ArrayList<String>();

    private int counter;
    private boolean aBoolean =true;
    long time = System.currentTimeMillis();
    private HashSet<String> gridSet = new HashSet<>();
    private HashMap<String, String> gridLogger = new HashMap<>();

    public GridLogger(LogWriter writer, Clock clock) {
        this.writer = writer;
        this.clock = clock;
        gridSet.add("Time");
        arrayAdd.add("Time");
        gridLogger.put("Time",Double.toString(clock.getCurrentTime()));


    }

    /**
     * Add a value to the logger under the category.  Categories are lazily added to the logger
     * in the order encountered.
     * @param category
     * @param value
     */
    public void add(String category, String value) {
        if(aBoolean && !gridSet.contains(category)){
            gridSet.add(category);
            arrayAdd.add(category);
        }
        gridLogger.put(category, value);

    }

    /**
     * Write a line of data to the log.  If this is the first call to writeLn, categories are
     * written first, followed by the line of data.  Once the data is written, the logger is reset
     * and calls to add() will add values to the next line of data.
     */
    public void writeLn() {
        if (aBoolean) {
            StringBuffer line = new StringBuffer();
            for (int i = 0; i < arrayAdd.size(); i++) {
                line.append(arrayAdd.get(i));
                if(i<arrayAdd.size()-1) {
                    line.append(", ");
                }
            }
            writer.writeLine(line.toString());
            aBoolean = false;
        }
        StringBuffer finalTitleLine = new StringBuffer();
        for(int a = 0; a<arrayAdd.size();a++){
            String category = arrayAdd.get(a);
            String value = gridLogger.get(category);
            if(value != null){
                finalTitleLine.append(value);
            }
            if (a < arrayAdd.size()-1){
                finalTitleLine.append(", ");
            }
        }
        writer.writeLine(finalTitleLine.toString());
        gridLogger.clear();
    }
    public long getTime(){
        return System.currentTimeMillis() - time;
    }

    public void stop() {}

}

