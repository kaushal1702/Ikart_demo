package com.Ikart.validations;

import java.util.Arrays;
import java.util.HashSet;

public class Validation {
	
	public static boolean validateState(String state) {
		
		String sts[] = {"andhra pradesh","arunachal pradesh","Assam","bihar","chhattisgarh","goa","gujarat","haryana","himachal Pradesh","jharkhand","karnataka","kerala","madhya pradesh","maharashtra","manipur","meghalaya","mizoram","nagaland","odisha","punjab","rajasthan","sikkim","tamil nadu","telangana","tripura","uttarakhand","uttar pradesh","west bengal"};
		HashSet<String> states = new HashSet<String>(Arrays.asList(sts));
		
		return states.contains(state.toLowerCase());
	}

}
