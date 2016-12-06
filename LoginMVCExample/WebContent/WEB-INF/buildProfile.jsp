<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html><head><META http-equiv="Content-Type" content="text/html; charset=utf-8"></head><body>
<html>
<head>
    <title>Questionnare</title>
</head>
<body>
<h2>${message}</h2><br/>
    <form action="mainMenu.html" method="POST"">
        <table>
        <tr>
        <td> Are you looking for an apartment</td>
        <td>
            <input type="radio" value="Yes" name="APT_SELECTION">Yes
        </td>
        <td>
            <input type="radio" value="No" name="APT_SELECTION">No, I already have one
        </td>
        </tr>
        <tr>
        <td> Which Area would you want to move in</td>
        <td><select name="area">
        <option value="CU On Campus">CU On Campus</option>
        <option value="CU Off Campus">CU Off Campus</option>
        <option value="Denver">Denver</option>
        <option value="Longmont">Longmont</option>
        </tr>
        <tr>
        <td> Maximum Rent</td>
        <td align="left">
            <input type="radio" value="500" name="Rent_sltn">$0-500
            <input type="radio" value="1000" name="Rent_sltn">$500-1000
            <input type="radio" value="1500" name="Rent_sltn">$1000-1500
            <input type="radio" value="2000" name="Rent_sltn">$1500-2000
        </td>
        </tr>
        <tr>
        <td> Your Preferred Room-mate</td>
        <td>
            <input type="radio" value="Female" name="gndr">Female
        </td>
        <td>
            <input type="radio" value="Male" name="gndr">Male
        </td>
        </tr>
        <tr>
        <td> Pets?</td>
        <td>
            <input type="radio" value="Yes" name="pts">I'm Okay with Pets
        </td>
        <td>
            <input type="radio" value="No" name="pts">I'm not Okay with having Pets
        </td>
        </tr>
        <tr>
        <td> Smoking?</td>
        <td>
            <input type="radio" value="Yes" name="smkr">I'm okay with smoking
        </td>
        <td>
            <input type="radio" value="No" name="smkr">No I don't tolerate smokers
        </td>
        </tr>
        <tr>
        <td> Drinking?</td>
        <td>
            <input type="radio" value="Yes" name="drnk">I'm okay with drinking
        </td>
        <td>
            <input type="radio" value="No" name="drnk">No I don't drink
        </td>
        </tr>
        <tr>
        <td> How often do you clean your dishes?</td>
        <td>
            <input type="radio" value="Yes" name="clns">Frequent
        </td>
        <td>
            <input type="radio" value="No" name="clns">Once in a while
        </td>
        </tr>
        <tr>
        <td> How often do you take out trash?</td>
        <td>
            <input type="radio" value="Yes" name="trsh">Frequent
        </td>
        <td>
            <input type="radio" value="No" name="trsh">Once in a while
        </td>
        </tr>
        <tr>
        <td> Do you like to Party?</td>
        <td>
            <input type="radio" value="Yes" name="prty">Yes, I love Parties
        </td>
        <td>
            <input type="radio" value="No" name="prty">No, I'm not a party guy
        </td>
        </tr>
        <tr>
        <td> Are you a vegan?</td>
        <td>
            <input type="radio" value="Yes" name="vgn">Yes I'm a vegan
        </td>
        <td>
            <input type="radio" value="No" name="vgn">No, I'm not a vegan
        </td>
        </tr>
        <tr>
        <td> Do you need a full room?</td>
        <td>
            <input type="radio" value="Yes" name="rm">Yes I need a full room
        </td>
        <td>
            <input type="radio" value="No" name="rm">No, I'm okay with sharing
        </td>
        </tr>
        <tr>
            <td><input type="reset" /></td>
            <td><input type="submit" value="Send Info" />
        </tr>
        </table>
    </form>
</body>
</html>