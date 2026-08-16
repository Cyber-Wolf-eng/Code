import java.util.Objects;

public class MarvelCharacter
{
    private String name;
    private String power;

    public MarvelCharacter(String name, String power)
    {
        this.name = name;
        this.power = power;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPower()
    {
        return power;
    }

    public void setPower(String power)
    {
        this.power = power;
    }

    @Override
    public String toString()
    {
        return name + ": " + power;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) //memory locations are the same
            return true;
        if (object == null || getClass() != object.getClass())//doesn't exist or class types are different
            return false;
        MarvelCharacter other = (MarvelCharacter) object;//now that we know the classes are the same, cast
        return name.equals(other.name) && power.equals(other.power);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, power);
    }
}