package es.sergiomendez;

public class Util {

    static public Integer[] stringToArray(String text) {

        Integer[] result;

        try {
            if (!text.startsWith("[") || !text.endsWith("]")) {
                throw new Exception("El String no empieza por '[' o acaba por ']'");
            } else if (!text.contains(",")) {
                throw new Exception("El String no tiene comas ',' como separador");
            }

            String trimmedText = text.substring(1, text.length() - 1);

            String[] splitedText = trimmedText.split(",");

            result = new Integer[splitedText.length];

            for (int i = 0; i < result.length; i++) {
                if (!splitedText[i].matches("[0-9]+")) {
                    throw new Exception("El String contiene caracteres que no son números enteros");
                }

                result[i] = Integer.parseInt(splitedText[i]);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            return null;
        }

        return result;
    }
}
