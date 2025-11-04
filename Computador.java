class Computador{

	
	Integer computa (ArvoreSintatica arv)
	{
		return (computa2(arv));
	}
	Integer computa2 (ArvoreSintatica arv)
	{

	if (arv instanceof Mult)
		return (computa2(((Mult) arv).arg1) * 
			computa2(((Mult) arv).arg2));

	if (arv instanceof Soma)
		return (computa2(((Soma) arv).arg1) + 
			computa2(((Soma) arv).arg2));

	if (arv instanceof Sub)
		return (computa2(((Sub) arv).arg1) - 
			computa2(((Sub) arv).arg2));

	if (arv instanceof Div)
		return (computa2(((Div) arv).arg1) / 
			computa2(((Div) arv).arg2));

	if (arv instanceof Num)
		return (((Num) arv).num);

	return 0;
	}
}
