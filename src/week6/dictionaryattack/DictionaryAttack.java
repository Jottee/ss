package week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


public class DictionaryAttack {
    private Map<String, String> passwordMap;
    private Map<String, String> hashDictionary;

    /**
     * Reads a password file. Each line of the password file has the form:
     * username: encodedpassword
     * <p>
     * After calling this method, the passwordMap class variable should be
     * filled withthe content of the file. The key for the map should be
     * the username, and the password hash should be the content.
     *
     * @param filename
     */
    public void readPasswords(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitname = line.split(": ");
                passwordMap.put(splitname[0], splitname[1]);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Given a password, return the MD5 hash of a password. The resulting
     * hash (or sometimes called digest) should be hex-encoded in a String.
     *
     * @param password
     * @return
     */
    public String getPasswordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] byteArray = md.digest(password.getBytes());
            String passwordHash = Hex.encodeHexString(byteArray);
            return passwordHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Checks the password for the user the password list. If the user
     * does not exist, returns false.
     *
     * @param user
     * @param password
     * @return whether the password for that user was correct.
     */
    public boolean checkPassword(String user, String password) {
        boolean ans = false;
        if (password != null) {
            ans = passwordMap.get(user).equals(getPasswordHash(password));
        }
        return ans;
    }

    /**
     * Reads a dictionary from file (one line per word) and use it to add
     * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
     *
     * @param filename filename of the dictionary.
     */
    public void addToHashDictionary(String filename) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String commonPassword;
            while ((commonPassword = br.readLine()) != null) {
                hashDictionary.put(getPasswordHash(commonPassword), commonPassword);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Do the dictionary attack.
     */
    public void doDictionaryAttack() {
        boolean found = false;
        for (String user : passwordMap.keySet()) {
            String password = hashDictionary.get(passwordMap.get(user));
            if (password != null) {
                System.out.println(user + " " + password);
                found = true;
            }
        }
        if (found) {
            System.out.println("Found password.");
        } else {
            System.out.println("Couldn't find password");
        }
    }

    public static void main(String[] args) {
        DictionaryAttack da = new DictionaryAttack();
        da.doDictionaryAttack();
    }

}
