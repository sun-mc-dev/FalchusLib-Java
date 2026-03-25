package com.falchus.lib.utils.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReflectionUtils {

    public static Class<?> getClass(@NonNull String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
        	return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Class<?> getFirstClass(@NonNull String... names) {
        for (String name : names) {
        	Class<?> found = getClass(name);
        	if (found != null) {
        		return found;
        	}
        }
        throw new RuntimeException("None of the classes exist: " + String.join(", ", names));
    }
    
    public static Field getField(@NonNull Class<?> clazz, @NonNull String name) {
    	Class<?> current = clazz;
    	
    	while (current != null) {
    		try {
    			Field field = current.getField(name);
    			field.setAccessible(true);
    			return field;
    		} catch (NoSuchFieldException ignored) {}
    		
    		try {
    			Field field = current.getDeclaredField(name);
    			field.setAccessible(true);
    			return field;
    		} catch (NoSuchFieldException ignored) {}
    		
    		current = current.getSuperclass();
    	}
    	return null;
    }
    
    public static Field getField(@NonNull Object instance, @NonNull String name) {
    	return getField(instance.getClass(), name);
    }
    
    public static Field getFirstField(@NonNull Class<?> clazz, @NonNull String... names) {
        for (String name : names) {
            Field found = getField(clazz, name);
            if (found != null) {
            	return found;
            }
        }
        throw new RuntimeException("None of the fields exist: " + String.join(", ", names));
    }
    
    public static Field getFirstField(@NonNull Object instance, @NonNull String... names) {
        return getFirstField(instance.getClass(), names);
    }
    
    public static Field getFirstField(@NonNull Set<Class<?>> classes, @NonNull String... names) {
    	for (Class<?> clazz : classes) {
    		try {
    			return getFirstField(clazz, names);
    		} catch (RuntimeException ignored) {}
    	}
        throw new RuntimeException("None of the fields exist in classes: " + classes + " - " + String.join(", ", names));
    }
    
    public static void setField(Object instance, @NonNull Field field, Object value) {
        try {
            field.set(instance, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void setField(Object instance, @NonNull String name, Object value) {
        try {
            setField(instance, getField(instance.getClass(), name), value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void setField(@NonNull Field field, Object value) {
    	setField(null, field, value);
    }
    
    public static void setField(@NonNull Class<?> clazz, @NonNull String name, Object value) {
        try {
            setField(getField(clazz, name), value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void setFirstField(Object instance, Object value, @NonNull String... names) {
    	setField(instance, getFirstField(instance, names), value);
    }
    
    public static void setFirstField(@NonNull Class<?> clazz, Object value, @NonNull String... names) {
    	setField(getFirstField(clazz, names), value);
    }
    
    public static void setFirstField(Object instance, @NonNull Set<Class<?>> classes, Object value, @NonNull String... names) {
    	for (Class<?> clazz : classes) {
    		try {
    			setField(instance, getFirstField(clazz, names), value);
    			return;
    		} catch (RuntimeException ignored) {}
    	}
        throw new RuntimeException("None of the fields exist in classes: " + classes + " - " + String.join(", ", names));
    }
    
    public static Method getMethod(@NonNull Class<?> clazz, @NonNull String name, Class<?>... params) {
    	Class<?> current = clazz;
    	
    	while (current != null) {
            try {
                Method method = current.getMethod(name, params);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException ignored) {}
            
            try {
                Method method = current.getDeclaredMethod(name, params);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException ignored) {}
            
        	current = current.getSuperclass();
    	}
    	return null;
    }
    
    public static Method getMethod(@NonNull Object instance, @NonNull String name, Class<?>... params) {
    	return getMethod(instance.getClass(), name, params);
    }
    
    public static Method getFirstMethod(@NonNull Class<?> clazz, List<Class<?>> params, @NonNull String... names) {
        for (String name : names) {
            Method found = getMethod(clazz, name, params.toArray(new Class[0]));
            if (found != null) {
                return found;
            }
        }
        throw new RuntimeException("None of the methods exist: " + String.join(", ", names));
    }
    
    public static Method getFirstMethod(@NonNull Object instance, List<Class<?>> params, @NonNull String... names) {
    	return getFirstMethod(instance.getClass(), params, names);
    }
    
    public static Method getFirstMethod(@NonNull Set<Class<?>> classes, List<Class<?>> params, @NonNull String... names) {
    	for (Class<?> clazz : classes) {
    		try {
    			return getFirstMethod(clazz, params, names);
    		} catch (RuntimeException ignored) {}
    	}
        throw new RuntimeException("None of the methods exist in classes: " + classes + " - " + String.join(", ", names));
    }
    
    public static Constructor<?> getConstructor(@NonNull Class<?> clazz, Class<?>... params) {
        try {
            Constructor<?> ctor = clazz.getDeclaredConstructor(params);
            ctor.setAccessible(true);
            return ctor;
        } catch (NoSuchMethodException e) {
        	return null;
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
    }
    
    public static Constructor<?> getConstructor(@NonNull Object instance, Class<?>... params) {
    	return getConstructor(instance.getClass(), params);
    }
    
    public static Constructor<?> getFirstConstructor(@NonNull Class<?> clazz, Set<List<Class<?>>> params) {
        for (List<Class<?>> list : params) {
        	Constructor<?> found = getConstructor(clazz, list.toArray(new Class[0]));
            if (found != null) {
                return found;
            }
        }
        throw new RuntimeException("No matching constructor found for class: " + clazz.getName());
    }
    
    public static Constructor<?> getFirstConstructor(@NonNull Object instance, Set<List<Class<?>>> params) {
    	return getFirstConstructor(instance.getClass(), params);
    }
    
    public static Constructor<?> getFirstConstructor(@NonNull Set<Class<?>> classes, Set<List<Class<?>>> params) {
    	for (Class<?> clazz : classes) {
    		try {
    			return getFirstConstructor(clazz, params);
    		} catch (RuntimeException ignored) {}
    	}
        throw new RuntimeException("No matching constructor found for classes: " + classes);
    }
}
