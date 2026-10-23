package lab2;

public class Time {
    long second;

    public Time(){
    }

    public Time(long second){
        setSecondTime(second);
    }

    public Time(long hours, long minutes, long seconds){
        this(hours * 3600 + minutes * 60 + seconds);
    }

    public Time(String time){
        setTime(time);
    }

    public void setSecondTime(long second){
        if (second < 0){
            throw new IllegalArgumentException("Время не может быть отрицательным");
        }
        this.second = second;
    }

    public void setTime(String time){
        if (time == null || time.isBlank()){
            throw new IllegalArgumentException("Строка времени пуста");
        }

        String[] blocks = time.split(",", -1);
        long total = 0;
        boolean hourFound = false;
        boolean minuteFound = false;
        boolean secondFound = false;

        for (String block : blocks){
            String[] parts = block.trim().split("\\s+");
            if (parts.length != 2){
                throw new IllegalArgumentException("Некорректный блок: '" + block + "'");
            }

            long value;
            try{
                value = Long.parseLong(parts[0]);
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("Не удалось прочитать число: '" + parts[0] + "'");
            }
            if (value < 0){
                throw new IllegalArgumentException("Время не может быть отрицательным");
            }

            String unit = parts[1].toLowerCase(java.util.Locale.ROOT);
            try{
                if (unit.equals("час") || unit.equals("часа") || unit.equals("часов")){
                    if (hourFound) throw new IllegalArgumentException("Часы указаны дважды");
                    hourFound = true;
                    total = Math.addExact(total, Math.multiplyExact(value, 3600));
                }
                else if (unit.equals("минута") || unit.equals("минуты") || unit.equals("минут") || unit.equals("мин")){
                    if (minuteFound) throw new IllegalArgumentException("Минуты указаны дважды");
                    if (value > 59) throw new IllegalArgumentException("Минуты должны быть от 0 до 59");
                    minuteFound = true;
                    total = Math.addExact(total, Math.multiplyExact(value, 60));
                }
                else if (unit.equals("секунда") || unit.equals("секунды") || unit.equals("секунд") || unit.equals("сек")){
                    if (secondFound) throw new IllegalArgumentException("Секунды указаны дважды");
                    if (value > 59) throw new IllegalArgumentException("Секунды должны быть от 0 до 59");
                    secondFound = true;
                    total = Math.addExact(total, value);
                }
                else{
                    throw new IllegalArgumentException("Неизвестная единица времени: '" + parts[1] + "'");
                }
            }
            catch (ArithmeticException e){
                throw new IllegalArgumentException("Слишком большое значение времени");
            }
        }

        this.second = total;
    }

    public int getHour(){
        return (int)(this.second / 3600 % 24);
    }

    public int getMinute(){
        return (int)(this.second / 60 % 60);
    }

    public int getSecond(){
        return (int)(this.second % 60);
    }

    public String getFullTime(){
        String formated_time = String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
        return formated_time;
    }
    @Override
    public String toString(){
        return getFullTime();
    }
}
