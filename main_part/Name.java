package lab2;

public class Name {
    String name;
    String surname;
    String patronymic;

    public Name(){
    }

    public Name(String line){
        if (!setFullName(line)){
            throw new IllegalArgumentException("Некорректное имя");
        }
    }

    public boolean setFullName(String line){
        boolean searchFlag = false;
        String[] parts;

        if (line == null || line.isBlank()){
            return false;
        }

        parts = line.trim().split("\\s+");
        searchFlag = parts.length >= 1 && parts.length <= 3;

        if (searchFlag){
            if (parts.length == 1){
                name = parts[0];
            }
            else if (parts.length == 2){
                surname = parts[0];
                name = parts[1];
            }
            else if (parts.length == 3){
                surname = parts[0];
                name = parts[1];
                patronymic = parts[2];
            }
        }
        return searchFlag;
    }

    public String getFullName(){
        String fullName = "";
        if (surname != null){
            fullName += surname + " ";
        }
        if (name != null){
            fullName += name;
        }
        if (patronymic != null){
            fullName += " " + patronymic;
        }
        return fullName;
    }
    
    @Override
    public String toString(){
        return getFullName();
    }
}
